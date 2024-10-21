# Exemplo resolvido - Fibonacci

[Preview](media/fib.gif)

Este exercício tem como objetivos:
- A criação de um novo projeto Android
- A criação de uma Activity
- Como mudar de Activity e enviar dados entre elas


## Criando seu projeto

Para criar um novo projeto no Android Studio siga o passo a passo em [Android Developers - Create a project](https://developer.android.com/studio/projects/create-project).

Na criação, escolha a opção `Empty Views Activity`, para iniciar o projeto com uma tela vazia.

## MainActivity

<!-- ![Interface da MainActivity](img/mainactivity_ui.png) -->

Na primeira tela, que vamos chamar de `MainActivity`, crie uma interface com os seguintes componentes:
- um label do tipo `TextView` com um título
- um campo de texto do tipo `EditText` para inserir o número
- um botão do tipo `Button` para enviar os dados

Você pode adicionar componentes pela interface do Android Studio ou editando o arquivo `res/layout/activity_main.xml`.

O layout correspondente a `MainActivity` é passado como argumento da função `setContentView`, dentro do [evento `onCreate`](https://developer.android.com/guide/components/activities/activity-lifecycle?hl=pt-br).:

```Java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);   
    [...]
    setContentView(R.layout.activity_main);
}
```

<details>
<summary>🧐 Mais sobre a classe R</summary>
A classe R é gerada automaticamente para identificação de recursos em um projeto Android, permitindo que os desenvolvedores acessem esses recursos de forma mais fácil e rápida. Fornece acesso a recursos do aplicativo, como imagens e arquivos de layout.

[Clique aqui](https://developer.android.com/reference/android/R) para saber mais sobre a classe R no Android.
</details>

### Input de dados

Para o nosso app, precisamos que ao apertar o botão, o valor inserido no campo de texto seja enviado para a próxima Activity.

Para  isso, precisamos criar um evento de clique no botão, que chamaremos de `btnClick`. Note que o evento deve ser definido com o mesmo nome tanto no XML do layout quanto na Activity.

```XML
<Button
    android:id="@+id/btnCalcular"
    android:onClick="btnClick"
    android:text="Calcular"
    [...] 
/>
```

```Java file="index.js"
public void btnClick(View v){
    EditText textInput = (EditText) findViewById(R.id.textInput);
    String text = textInput.getText().toString();
    Integer number = Integer.parseInt(text);

    Intent intent = new Intent(this, ResultActivity.class);
    intent.putExtra("number", number); 
    // 
    startActivity(intent);
}
```

Vamos destacar alguns detalhes:
- `btnClick` é o evento de clique no botão, que será chamado quando o usuário clicar no botão
- `findViewById` é a função utilizada para obter uma referência do elemento da interface
- '`textInput` é o `android:id` definido no XML da interface
- `"number"` é a chave para obter o valor na próxima Activity
- `ResultActivity` é a próxima Activity que será iniciada


### ResultActivity

Na `ResultActivity`, basta receber o valor enviado pela `Intent` utilizando a chave `"nome"`, calcular o valor de fibonacci do número e apresentar no `TextView`.

```Java
@Override
protected void onCreate(Bundle savedInstanceState) {
    [...]
    
    Intent intent = getIntent();
    Integer defaultValue = 0;
    Integer number = intent.getIntExtra("number", defaultValue);

    Integer result = fib(number);
    TextView resultText = (TextView) findViewById(R.id.resultText);
    resultText.setText(result.toString());
}
```