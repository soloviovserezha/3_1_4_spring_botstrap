# 3_1_4_spring_bootstrap

1) Выставлена настройка: ```spring.jpa.hibernate.ddl-auto=create```

2) Была некоторая проблема с удалением новых записей, которые добавлялись через
интерфейс программы (в браузере). Вот такого рода лог получал. 
Удаление имеющихся записей происходило без проблем.

>Cannot delete or update a parent row: a foreign key constraint fails 
> (`preproject_1`.`users_roles`, CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` 
> FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`))

Погуглил/посмотрел индусов, понял, что в структуре смехы, в колонках 
>Drop ON DELETE / ON UPDATE можно заменить 'RESTRINCT' на 'CASCADE' 

и поверх запрос писать:
>```ALTER TABLE 'название_таблицы' ADD CONSTRAINT и тп```

и норм заработало все у спикера. Я такую настройку не проводил у себя.

Можно ли добавить что-то подобное в спринг через какие-нибудь аннотации,
чтобы не фейлилось? 

3) По итогу, проблему решил добавлением кучи каскадов, 
но это что-то меня изрядно запутало
```
@Cascade({
    org.hibernate.annotations.CascadeType.SAVE_UPDATE,
    org.hibernate.annotations.CascadeType.MERGE,
    org.hibernate.annotations.CascadeType.PERSIST
})
```
хз, верно ли такое решение вообще, хотя вроде работает все теперь
