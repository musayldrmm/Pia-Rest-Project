package com.example.demo.API;

import com.example.demo.hashpassword.HashPassword;
import com.example.demo.entity.User;
import com.example.demo.repository.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class Userapi {
    @Autowired
    private User_repo user_repo;
    @PostMapping()
    public User add(@RequestBody User user){
        HashPassword hashing=new HashPassword(user.getPassword());
        user.setPassword(hashing.getPasswordToHash());
        return user_repo.save(user);
    }
    @PostMapping("/login")
    public User loginuser(@RequestBody User user){
        HashPassword hashing=new HashPassword(user.getPassword());
        user.setPassword(hashing.getPasswordToHash());
      User login= user_repo.findByEmail(user.getEmail());
      User password = user_repo.findByPassword(user.getPassword());
      if (login!=null){
          if(password!=null){
              System.out.println("LOGİN OLDUN");
              return login;
          }
      else{
              System.out.println("Şifren  yanlış");
          return null;
          }
      }
      else{
System.out.println("EMail yanluş");
          return null;
      }
   }

    @GetMapping("/all")
    public ResponseEntity<List<User>> alluser(){
        return ResponseEntity.ok(user_repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getuser(@PathVariable String id){
        return ResponseEntity.ok(user_repo.findById(id));
    }
    @GetMapping("/remove/{id}")
    public String deleteuser(@PathVariable String id){
   user_repo.deleteById(id);
   return "user deleted with id : "+id;
    }
}
