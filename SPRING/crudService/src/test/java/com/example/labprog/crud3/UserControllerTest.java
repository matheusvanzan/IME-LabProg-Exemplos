package com.example.labprog.crud3;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.labprog.crud3.controllers.UserController;
import com.example.labprog.crud3.entities.User;
import com.example.labprog.crud3.services.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        // Any setup code goes here
    }

    @Test
    void testGetAllUsers() throws Exception {
        String mockUsername = "testuser1";
        User mockUser = new User();
        mockUser.setUsername(mockUsername);
        
        when(userService.findAll()).thenReturn(List.of(mockUser));

        mockMvc.perform(get("/users/all"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].username").value(mockUsername));
    }

    // @Test
    // void testSearchUserByUsername() throws Exception {
    //     User user = new User();
    //     user.setUsername("testuser");
    //     when(userService.findByUsername("testuser")).thenReturn(user);

    //     mockMvc.perform(get("/users/search/{username}", "testuser"))
    //         .andExpect(status().isOk())
    //         .andExpect(jsonPath("$.username").value("testuser"));
    // }

    // @Test
    // void testCreateUser() throws Exception {
    //     User user = new User();
    //     user.setUsername("testuser");
    //     when(userService.createUser("testuser", "password")).thenReturn(user);

    //     mockMvc.perform(post("/users/create")
    //             .param("username", "testuser")
    //             .param("password", "password"))
    //         .andExpect(status().isOk())
    //         .andExpect(jsonPath("$.status").value("User created"))
    //         .andExpect(jsonPath("$.user.username").value("testuser"));
    // }

    // @Test
    // void testUpdateUserById() throws Exception {
    //     User user = new User();
    //     user.setUsername("updatedUser");
    //     when(userService.updateUsername(1, "updatedUser")).thenReturn(user);

    //     mockMvc.perform(put("/users/update/{id}", 1)
    //             .param("username", "updatedUser"))
    //         .andExpect(status().isOk())
    //         .andExpect(jsonPath("$.status").value("User created"))
    //         .andExpect(jsonPath("$.user.username").value("updatedUser"));
    // }

    // @Test
    // void testDeleteUserById() throws Exception {
    //     when(userService.deleteUser(1)).thenReturn(true);

    //     mockMvc.perform(delete("/users/delete/{id}", 1))
    //         .andExpect(status().isOk())
    //         .andExpect(content().string("true"));
    // }
}
