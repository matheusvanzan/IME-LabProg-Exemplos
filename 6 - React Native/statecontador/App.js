import React, {useState} from 'react';
import { View, Text, Button, SafeAreaView, StyleSheet  } from 'react-native';


type ContadorProps =  {
  name: string;
}

const Contador = (props: ContadorProps) => {
  const [getCount, setCount] = useState(0);

  return (
    <View>
      <Text>
        Nome {props.name}: {getCount}
      </Text>
      <Button
        onPress={() => {
          var c = getCount;
          setCount(c+1);
        }}
        title='Contar'
      />
    </View>
  );
}

const App = () => {
  return (
    <SafeAreaView style={styles.container}>
      <Contador name="Contador 1" />
      <Contador name="Contador 2" />
    </SafeAreaView>
  )
};

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor: '#ecf0f1',
    padding: 8,
  },
});

