[when]来店客の年齢が {age} 才未満 = $person : Person(age < {age})
[when]来店客の年齢が {age} 才以上 = $person : Person(age >= {age})
[when]ドリンクが注文される = $drink : Drink()

[then]"{name}"を提供する = $drink.setName( "{name}" );
[then]料金は {charge} 円 = $drink.setCharge( {charge} );
