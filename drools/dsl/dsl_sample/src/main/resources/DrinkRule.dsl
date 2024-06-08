[when]ドリンクが注文される = $drink : Drink()
[when]来店客の年齢が {age} 才未満 = Person(age < {age})
[when]来店客の年齢が {age} 才以上 = Person(age >= {age})

[then]オレンジジュースをお出しする = $drink.setName( "Orange Juice" );
[then]オレンジジュースの料金は100円 = $drink.setCharge( 100 );
[then]ビールをお出しする = $drink.setName( "Beer" );
[then]ビールの料金は200円 = $drink.setCharge( 200 );
