import React, {useState} from 'react';
import {
  SafeAreaView,
  View,
  FlatList,
  StyleSheet,
  Text,
  StatusBar,
} from 'react-native';

const Item = ({id, email}) => (
  <View style={styles.item}>
    <Text style={styles.title}>{id} - {email}</Text>
  </View>
);

var initialData = [
  { id: 0, email: 'ricardo.franco@ime.eb.br', },
];

const App = () => {
  
  const [dataLoaded, setDataLoaded] = useState(false);
  const [data, setData] = useState(initialData);

  if (!dataLoaded) {
    setDataLoaded(true);

    fetch('https://reqres.in/api/users')
      .then(response => response.json())
      .then(json => {

        var newData = data; // or []
        json.data.forEach((item) => {
          console.log(Date(), newData);
          newData.push({id: item.id, email: item.email});          
          
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
        data={data}
        renderItem={({item}) => <Item id={item.id} email={item.email} />}
        keyExtractor={item => item.id}
      />
    </SafeAreaView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: StatusBar.currentHeight || 0,
  },
  item: {
    backgroundColor: '#c5cae9',
    padding: 20,
    marginVertical: 8,
    marginHorizontal: 16,
  },
  title: {
    fontSize: 20,
  },
});

export default App;