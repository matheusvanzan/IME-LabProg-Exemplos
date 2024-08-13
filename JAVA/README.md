# Exemplos de Java

## Criar uma cópia de um Array

```
public static String[] copyArray(String[] arrayOriginal) {

    String[] arrayCopy = new String[arrayOriginal.length];

    for (int i = 0; i < arrayOriginal.length; i++) {
        arrayCopy[i] = arrayOriginal[i];
    }
    
    return arrayCopy;
}
```