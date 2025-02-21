import React, {useState} from 'react';
import { View, Text, StyleSheet, Button, TextInput, Image } from 'react-native';

import { NavigationContainer, useRoute  } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const LoginScreen = ({ navigation }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  return (
    <View style={styles.container}>
      <Image style={styles.logo}
          source={require('./assets/logo.png')}
      />
      <TextInput style={styles.input}
        placeholder='Username'
        placeholderTextColor="lightgray"
        onChangeText = {(t) => setUsername(t)}
      />
      <TextInput style={styles.input}
        placeholder='Password'
        placeholderTextColor="lightgray"
        secureTextEntry={true}
        onChangeText = {(t) => setPassword(t)}
      />
      <View style={styles.buttonStyle}>
        <Button
          title="Login"
          onPress={() => navigation.navigate("HomeScreen", { username, password })}
        />
      </View>
      <Text>state: {username}, {password}</Text>
    </View>
  );
}

const HomeScreen = ({ navigation }) => {
  const route = useRoute()
  const username = route.params?.username
  const password = route.params?.password
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Username: {username}</Text>
      <Text style={styles.text}>Password: {password}</Text>
      <Button
        title="Sair"
        onPress={() => navigation.goBack()}
      />
    </View>
  );
}

const Stack = createNativeStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="LoginScreen" component={LoginScreen} />
        <Stack.Screen name="HomeScreen" component={HomeScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  logo: {
    width: "40%",
    height: "30%",
    margin: 10,
  },
  input: {
    margin: 10,
    padding: 5,
    borderColor: 'black',
    borderWidth: 1,
  },
  buttonStyle: {
    padding: 15,
    width: 200,
  },
  text: {
    margin: 10,
  }
});

