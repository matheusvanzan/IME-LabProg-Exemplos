import React, { Component } from 'react';
import { StyleSheet, View, Text, Image, Button, TouchableHighlight } from 'react-native';
import { images } from './images';


export default class MyProject extends Component {

    constructor() {
        super();
        this.state = {
            FacePadrao: 1
        }
    }

    jogarDado = () => {
        var RandomNumber = Math.floor(Math.random() * 5) + 1;
        // 0 - 1 => 0 - 5 (3.5) => 0 - 5 (3) => 1 - 6
        this.setState({
            FacePadrao: RandomNumber,
        })
    }

    render() {
        var imgSource;
        var cond = this.state.FacePadrao;

        console.log(cond);

        if (cond == 1) {
            imgSource = images.d1.uri;
        }
        if (cond == 2) {
            imgSource = images.d2.uri;
        }
        if (cond == 3) {
            imgSource = images.d3.uri;
        }
        if (cond == 4) {
            imgSource = images.d4.uri;
        }
        if (cond == 5) {
            imgSource = images.d5.uri;
        }
        if (cond == 6) {
            imgSource = images.d6.uri;
        }

        return (
            <View style={styles.MainContainer} >

                <Text style={styles.titulo}>
                    Vamos tentar a sorte?
                </Text>

                <Image style={styles.tinylogo}
                    source={require('./assets/jogodados.png')}
                />

                <TouchableHighlight onPress={() => this.jogarDado()}>
                    <Image source={imgSource} />
                </TouchableHighlight>

            </View>
        );
    }
}

const styles = StyleSheet.create({
    titulo: {
        fontSize: 24,
        fontWeight: "bold",
        padding: 30,
    },
    tinylogo: {
        width: "60%",
        height: "30%",
    },
    MainContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    }
});