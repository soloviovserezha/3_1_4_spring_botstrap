# 3_1_4_spring_bootstrap

1) Выставлена настройка: ```spring.jpa.hibernate.ddl-auto=create```


2) Думаю в репозитории нужно оставить этот квери, чтобы фетчТайп LAZY был
присвоился
```java
@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username= :username")
```
