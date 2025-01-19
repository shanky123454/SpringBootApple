insert into role (role_id, role_name) values(1,'ADMIN');
insert into role (role_id, role_name) values(2,'USER');

insert into users ( user_id,username, password,disabled,account_expired,account_locked,
credentials_expired) values(1,'shanky', 'shanky@123',0,0,0,0);

insert into users ( user_id,username, password,disabled,account_expired,account_locked,
credentials_expired) values(2,'ritu', 'ritu@123',0,0,0,0);

insert into user_role (user_id, role_id) values(1,1);
insert into user_role (user_id, role_id) values(2,2);