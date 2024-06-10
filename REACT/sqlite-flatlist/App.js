import React, { useState, useEffect  } from 'react';
import { SafeAreaView, View, FlatList, StyleSheet, Text, StatusBar, TouchableHighlight, Image, Button, TextInput } from 'react-native';

import { NavigationContainer, useRoute, useFocusEffect  } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import * as DB from './db';

var initialData = [
  {
    id: 0,
    first_name: 'Ricardo',
    last_name: 'Franco',
    email: 'ricardo.franco@ime.eb.br',
    uri: 'https://www.eb.mil.br/documents/20119/36787/quadroEngenheirosMilitaresRicardoFrancoOriginal.jpg'
  },
];

const Item = ({item}) => (
    <View style={styles.item}>
      <Image source={{uri: item.uri}} style={styles.itemImage}/>
      <View>
        <Text style={styles.title}>{item.first_name} {item.last_name}</Text>
        <Text style={styles.title}>{item.email}</Text>
      </View>
    </View>
);


const Home = ({ navigation }) => {
  
  const [data, setData] = useState(initialData);

  useEffect(() => {
    DB.create();
  }, []);

  useFocusEffect (() => {
    DB.listAll()
    .then(dt => setData(dt))    

  });

  return (
    <SafeAreaView style={styles.container}>
      <FlatList
        data = {data}
        renderItem = { ({item}) => (
          <TouchableHighlight
            onPress={() => { navigation.navigate("Details", { item: item }) }}>
            <Item item={item} />
          </TouchableHighlight>
        )}
        keyExtractor = {item => item.id}
      />

      <Button
        title="Add New User"
        onPress={() => { navigation.navigate("AddNew", {}) }}>
        </Button>
    </SafeAreaView>
  );
};

const Details = ({ navigation }) => {

  const route = useRoute()
  const item = route.params?.item

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.details}>
        <Image source={{uri: item.uri}} style={styles.detailsImage}/>
        <View>
          <Text style={styles.title}>{item.first_name} {item.last_name}</Text>
          <Text style={styles.title}>{item.email}</Text>
        </View>
      </View>
    </SafeAreaView>
  );
}

const AddNew = ({ navigation }) => {

  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');

  async function save() {
    DB.insert(firstName, lastName, email, '');
    navigation.goBack();
  }

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.details}>

        <Text>First Name</Text>
        <TextInput style={styles.input}
          onChangeText = {(t) => setFirstName(t)}
        />

        <Text>Last Name</Text>
        <TextInput style={styles.input}
          onChangeText = {(t) => setLastName(t)}
        />

        <Text>Email</Text>
        <TextInput style={styles.input}
          onChangeText = {(t) => setEmail(t)}
        />

        <Button
        title="Save"
        onPress={() => save() }>
        </Button>

      </View>
    </SafeAreaView>
  );
}

const Stack = createNativeStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Details" component={Details} />
        <Stack.Screen name="AddNew" component={AddNew} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({

  // All
  container: {
    flex: 1,
    marginTop: StatusBar.currentHeight || 0,
  },

  // Home
  item: {
    flexDirection: 'row',
    backgroundColor: '#c5cae9',
    padding: 10,
    margin: 5,
  },
  title: {
    fontSize: 20,
    marginTop: 10
  },  
  itemImage: { 
    width: 70, 
    height: 70,
    margin: 10, 
  },

  // Details
  details: {
    padding: 10,
    margin: 5,
  },
  detailsImage: { 
    width: 200, 
    height: 200,
    margin: 10, 
  },
  input: {
    margin: 10,
    padding: 5,
    borderColor: 'black',
    borderWidth: 1,
  },
});

export default App;