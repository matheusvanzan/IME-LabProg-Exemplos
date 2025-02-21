import React, {useState} from 'react';
import {SafeAreaView, View, FlatList, StyleSheet, Text, StatusBar, TouchableHighlight, Image} from 'react-native';

import { NavigationContainer, useRoute  } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

const Item = ({item}) => (
    <View style={styles.item}>
      <Image source={{uri: item.uri}} style={styles.itemImage}/>
      <View>
        <Text style={styles.title}>{item.first_name} {item.last_name}</Text>
        <Text style={styles.title}>{item.email}</Text>
      </View>
    </View>
);

var initialData = [
  {
    id: 0,
    first_name: 'Ricardo',
    last_name: 'Franco',
    email: 'ricardo.franco@ime.eb.br',
    uri: 'https://www.eb.mil.br/documents/20119/36787/quadroEngenheirosMilitaresRicardoFrancoOriginal.jpg'
  },
];


const Home = ({ navigation }) => {
  
  const [dataLoaded, setDataLoaded] = useState(false);
  const [data, setData] = useState(initialData);

  if (!dataLoaded) {
    setDataLoaded(true);

    fetch('https://reqres.in/api/users')
      .then(response => response.json())
      .then(json => {

        var newData = data; // or []
        json.data.forEach((item) => {
          console.log(Date(), item);
          newData.push({
            id: item.id,
            first_name: item.first_name, 
            last_name: item.last_name, 
            email: item.email, 
            uri: item.avatar,
          });          
        });

        setData(newData);
        
      })
      .catch(error => {
        console.error(error);
    });
  }

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

const Stack = createNativeStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="Details" component={Details} />
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
  }
});

export default App;