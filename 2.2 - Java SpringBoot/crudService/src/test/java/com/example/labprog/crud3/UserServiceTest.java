package com.example.labprog.crud3;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.labprog.crud3.entities.User;
import com.example.labprog.crud3.repositories.UserRepository;
import com.example.labprog.crud3.services.UserService;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test cases will go here

    @Test
    void createUser_ShouldCreateUser_WhenValidDataProvided() {

        // Create mock data
        String mockUsername = "testuser";
        String mockPassword = "password";
        User mockUser = new User();
        mockUser.setUsername(mockUsername);
        mockUser.setPassword(mockPassword);

        // Define mock behaviour
        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        // test creating user
        User createdUser = userService.createUser(mockUsername, mockPassword);

        assertNotNull(createdUser);
        assertEquals(mockUsername, createdUser.getUsername());
        assertEquals(mockPassword, createdUser.getPassword()); // Password should ideally be hashed
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void findByUsername_ShouldReturnUser_WhenUserExists() {
        String mockUsername = "testuser";
        User mockUser = new User();
        mockUser.setUsername(mockUsername);
        Optional<User> optUser = Optional.of(mockUser);

        when(userRepository.findByUsername(mockUsername)).thenReturn(optUser);

        Optional<User> foundOptUser = userService.findByUsername(mockUsername);
        
        assertNotNull(foundOptUser);
        assertTrue(foundOptUser.isPresent());
        assertEquals(optUser.getClass(), foundOptUser.getClass());

        User foundUser = foundOptUser.get();
        assertEquals(mockUsername, foundUser.getUsername());
    }

    @Test
    void findByUsername_ShouldReturnNull_WhenUserDoesNotExist() {
        String mockUsername = "nonexistent";
        Optional<User> userNotFound = Optional.empty();

        when(userRepository.findByUsername(mockUsername)).thenReturn(userNotFound);

        Optional<User> foundOptUser = userService.findByUsername(mockUsername);

        assertFalse(foundOptUser.isPresent());
        assertEquals(userNotFound.getClass(), foundOptUser.getClass());
    }


}

