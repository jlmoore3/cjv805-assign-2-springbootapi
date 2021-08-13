package com.example.andchill.services;

import com.example.andchill.models.UserModel;
import com.example.andchill.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public List<UserModel> getUsers(){
        return repository.findAll();
    }

    public Optional<UserModel> getUserById(String id) {
        Optional<UserModel> user = repository.findById(id);
        if (user.isEmpty())
            try {
                throw new Exception ("Could not find user with id: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return user;
    }


    /* Register user function and validation
    * Create an endpoint that will create users. */
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserModel addUser(UserModel userModel) {
        String encodedPW = bCryptPasswordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPW);
        if (userModel.getUsername().isEmpty()) {
            try {
                throw new Exception ("Could not create user - missing username");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (repository.findByUsername(userModel.getUsername()) != null) {
            try {
                throw new Exception ("Could not create user - username is taken");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            repository.insert(userModel);
        }
        return userModel;
    }

    public UserModel editUser (String id, UserModel newUser) {
        Optional<UserModel> user = repository.findById(id);
        if (user.isEmpty())
        {
            try {
                throw new Exception ("Could not find user with id: " + id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Update fName, but only if provided
        if (newUser.getfName().isEmpty()) {
            System.out.println("No First Name provided for update; FName not updated");
        }
        else {
            user.get().setfName(newUser.getfName());
        }
        //Update lName, but only if provided
        if (newUser.getlName().isEmpty()) {
            System.out.println("No Last Name provided for update; LName not updated");
        }
        else {
            user.get().setlName(newUser.getlName());
        }

        UserModel updateUser = repository.save(user.get());
        return updateUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserModel foundUser = repository.findByUsername(username);
            String un = foundUser.getUsername();
            String pw = foundUser.getPassword();
            System.out.println(un + pw);
            return new User(un, pw, new ArrayList<>());
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }


    }

}
