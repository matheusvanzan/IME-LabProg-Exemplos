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

public static String[] copyArray2(String[] arrayOriginal) {

    ArrayList<String> listCopy = new ArrayList<String>();

    for (String c : arrayOriginal) {
        listCopy.add(c);
    }
    
    String[] arrayCopy = new String[listCopy.size()];
    listCopy.toArray(arrayCopy);
    return arrayCopy;
}
```