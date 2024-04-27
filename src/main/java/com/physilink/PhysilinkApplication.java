package com.physilink;

import com.physilink.model.task.Task;
import com.physilink.repository.task.TaskRepository;
import com.physilink.repository.user.UserRepository;
import com.physilink.model.user.Role;
import com.physilink.model.user.User;
import com.physilink.repository.user.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
/**
 * Vignesh G
 */
public class PhysilinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhysilinkApplication.class, args);
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, TaskRepository taskRepository) {
        return args -> {
            //Create Admin and Passenger Roles
            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                adminRole = new Role();
                adminRole.setRole("ADMIN");
                roleRepository.save(adminRole);
            }

            Role aidosRole = roleRepository.findByRole("AIDOS");
            if (aidosRole == null) {
                aidosRole = new Role();
                aidosRole.setRole("AIDOS");
                roleRepository.save(aidosRole);
            }

            Role ctRole = roleRepository.findByRole("CT");
            if (ctRole == null) {
                ctRole = new Role();
                ctRole.setRole("CT");
                roleRepository.save(ctRole);
            }

            Role medinsRole = roleRepository.findByRole("MEDINS");
            if (medinsRole == null) {
                medinsRole = new Role();
                medinsRole.setRole("MEDINS");
                roleRepository.save(medinsRole);
            }

            //Create an Admin user
            User admin = userRepository.findByEmail("g.vignesh1523@gmail.com");
            if (admin == null) {
                admin = new User()
                        .setEmail("g.vignesh1523@gmail.com")
                        .setPassword("$2a$10$7PtcjEnWb/ZkgyXyxY1/Iei2dGgGQUbqIIll/dt.qJ8l8nQBWMbYO") // "123456"
                        .setFirstName("Vignesh")
                        .setLastName("G")
                        .setMobileNumber("9385581203")
                        .setRoles(new HashSet<>(Arrays.asList(adminRole)));
                userRepository.save(admin);
            }

            User aidos = userRepository.findByEmail("aidos@gmail.com");
            if (aidos == null) {
                aidos = new User()
                        .setEmail("aidos@gmail.com")
                        .setPassword("$2a$10$Wn.pYxKikAUZsPsIe/Tfu.TmpDt6tPB/X9gC/sEnSDwghCgSF9jRy") // "aidos"
                        .setFirstName("Aidos")
                        .setLastName("")
                        .setMobileNumber("9385581203")
                        .setRoles(new HashSet<>(Arrays.asList(aidosRole)));
                userRepository.save(aidos);
            }

            User ct = userRepository.findByEmail("ct@gmail.com");
            if (ct == null) {
                ct = new User()
                        .setEmail("ct@gmail.com")
                        .setPassword("$2a$10$9QOCsFzXgdA/b15hvD/jo.sM3Gp51mikqJy7arOC18LYvYF7PACdy") // "caretaker"
                        .setFirstName("Ct")
                        .setLastName("")
                        .setMobileNumber("9385581203")
                        .setRoles(new HashSet<>(Arrays.asList(ctRole)));
                userRepository.save(ct);
            }

            User medins = userRepository.findByEmail("medins@gmail.com");
            if (medins == null) {
                medins = new User()
                        .setEmail("medins@gmail.com")
                        .setPassword("$2a$10$gYVh/m4CBH30m/v7RI5st.BJ.0nKzBPmRrsq4Yrll8jWTDrpNCdB6") // "medins"
                        .setFirstName("MedIns")
                        .setLastName("")
                        .setMobileNumber("9385581203")
                        .setRoles(new HashSet<>(Arrays.asList(medinsRole)));
                userRepository.save(medins);
            }

            Task task = taskRepository.findByTaskName("Sleep");
            if(task == null) {
                task = new Task()
                        .setTaskName("Sleep")
                        .setCompleted(false);
                taskRepository.save(task);
            }

        };
    }
}
