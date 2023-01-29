# consequence_variables

https://docs.drools.org/7.59.0.Final/drools-docs/html_single/index.html#executable-model-con_packaging-deploying

- then句内で使用できるvariableの数(24個まで)を検証
- [検証対象DRL](./src/main/resources/Drink.drl)
- 以下コマンド実行で確認
```
./mvnw  clean install -DgenerateModel=YES
```
