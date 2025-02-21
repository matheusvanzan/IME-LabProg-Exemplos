import React, {useState} from 'react';
import { View, Text, StyleSheet, Button, TextInput } from 'react-native';

import { NavigationContainer, useRoute  } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const ScreenA = ({ navigation }) => {
  const [getN, setN] = useState(0);

  return (
    <View style={styles.container}>
      <Text>Entre com o número</Text>
      <TextInput style={styles.input}
        onChangeText = {(t) => setN(t)}
       />
      <Button
        title="Go to Screen B"
        onPress={() => navigation.navigate("Screen B", { n: getN })}
      />
      <Text>getN: {getN}</Text>
    </View>
  );
}

const ScreenB = ({ navigation }) => {
  const route = useRoute()
  const n = route.params?.n
  return (
    <View style={styles.container}>
      <Text style={styles.text}>O número escolhido foi: {n}</Text>
      <Button
        title="Voltar"
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
        <Stack.Screen name="Screen A" component={ScreenA} />
        <Stack.Screen name="Screen B" component={ScreenB} />
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
  input: {
    margin: 10,
    borderColor: 'black',
    borderWidth: 1,
  },
  text: {
    margin: 10,
  }
});

