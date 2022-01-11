package com.example.demo.model;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty()

    private String fName;
    private String lName;
    @Min(18)
    private Integer age;
    private String className;

//    public int getId(){
//        return id;
//    }
//    public void setId(int id){
//        this.id = id;
//    }
//    public String getlName(){
//        return lName;
//    }
//    public void setlName(String lName){
//        this.lName = lName;
//    }
//    public int getAge(){
//        return age;
//    }
//    public void setAge(int age){
//        this.age = age;
//    }
//    public String getClassName(){
//        return className;
//    }
//    public void setClassName(String className){
//        this.className = className;
//    }
}
