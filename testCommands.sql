use csedconnections;



insert into graduate values ("moaz1@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695101" , "123456" ,"https://upload.wikimedia.org/wikipedia/commons/1/18/Mark_Zuckerberg_F8_2019_Keynote_%2832830578717%29_%28cropped%29.jpg
" ,"Hi i am moaz","2023");
insert into graduate values ("omar@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695102" , "123456" ,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Steve_Jobs.jpg/527px-Steve_Jobs.jpg
" ,"Hi i am moaz","2023");
insert into graduate values ("ahmed@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695104" , "123456" ,"https://images.moneycontrol.com/static-mcnews/2020/02/BILL-GATES-770x433.jpg?impolicy=website&width=770&height=431
" ,"Hi i am moaz","2023");
insert into graduate values ("abelrahman@gmail.com", "moaz" , "2000-02-23" , "M" , "01021695104" , "123456" ,"https://assets.entrepreneur.com/content/3x2/2000/1626297217-sundar-pichai-4542.jpeg?crop=4:3
" ,"Hi i am moaz","2023");

insert into experience values("moaz1@gmail.com" , "google" ,"silicon vally" ,"ceo" ,"2024","20--");
insert into experience values("omar@gmail.com" , "google" ,"silicon vally" ,"ceo" ,"2023","20--");
insert into experience values("abelrahman@gmail.com" , "facebook" ,"al atf" ,"ceo" ,"2024","20--");
insert into experience values("ahmed@gmail.com" , "apple" ,"silicon vally" ,"ceo" ,"2024","20--");

select graduate.name ,graduate.email ,graduate.imageURL,experience.company ,experience.location
from graduate JOIN experience 
on experience.email=graduate.email;

select email
from graduate
where email="moaz@gmail.com" AND password="1253456";

insert into graduate values ('moaznabil886@gmail.com' , 'Moaz Nabil' , '23-2-2000' , 'M' , '0100000' , '123456879' , 'url' , 'Hi' , '2023' );

select * from graduate;
select * from experience;