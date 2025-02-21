import React, { Component } from 'react';
import { SafeAreaView, Text, TextInput, Button, View } from 'react-native';

// or any files within the Snack
import Fibonacci from './components/Fibonacci';


export default class MyProject extends Component {

  constructor(props) {
    super(props);
    
    this.state = {
      a: '',
      b: '',
      sum: '',
    };
  }

  handleInputChange = (name, value) => {
    this.setState({ [name]: value });
  };

  onClick = () => {
    const { a, b } = this.state;
    const sum = parseFloat(a) + parseFloat(b);
    this.setState({ sum });
  }

  render() {
    return (
      <SafeAreaView>
        <View style={{ padding: 20 }}>
          <Text>a = </Text>
          <TextInput
            style={{ height: 40, borderColor: 'gray', borderWidth: 1 }}
            keyboardType="numeric"
            onChangeText={(text) => this.handleInputChange('a', text)}
            value={this.state.a}
          />
          
          <Text>b = </Text>
          <TextInput
            style={{ height: 40, borderColor: 'gray', borderWidth: 1 }}
            keyboardType="numeric"
            onChangeText={(text) => this.handleInputChange('b', text)}
            value={this.state.b}
          />

          <Button
            onPress={this.onClick}
            title="Calculate Sum"
            color="#841584"
            accessibilityLabel="Calculate the sum of a and b"
          />

          {this.state.sum !== null && (
            <Text>Sum = {this.state.sum}</Text>
          )}
        </View>
      </SafeAreaView>
    )
  }
}