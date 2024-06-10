import { Text, View, StyleSheet, Image, TextInput } from 'react-native';

export default function Fibonacci() {

  const text = "teste"

  return (
    <View style={styles.container}>
      <Text style={styles.paragraph}>
        Insira um número
      </Text>
      <TextInput value={text} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
    padding: 24,
  },
  paragraph: {
    margin: 24,
    marginTop: 0,
    fontSize: 14,
    fontWeight: 'bold',
    textAlign: 'center',
  },
  logo: {
    height: 128,
    width: 128,
  }
});
