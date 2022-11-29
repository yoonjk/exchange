CREATE TABLE exchange(
    cur_unit varchar(3) NOT NULL,
    base_dt  varchar(8) NOT NULL,
    tts      varchar(20) NOT NULL,
    ttb      varchar(20) NOT NULL,
    deal_bas_r varchar(20) NOT NULL,
    cur_nm   varchar(100),
    PRIMARY KEY (cur_unit asc, base_dt desc)
);

insert into exchange (cur_unit, base_dt, tts, ttb, deal_bas_r, cur_nm)
values ('USD','20221125', '1124.27', '1129.27', '1124.27', '달러');
insert into exchange (cur_unit, base_dt, tts, ttb, deal_bas_r, cur_nm)
values ('USD','20221124', '1124.27', '1129.27', '1124.27', '달러');

insert into exchange (cur_unit, base_dt, tts, ttb, deal_bas_r, cur_nm)
values ('USD','20221123', '1124.27', '1129.27', '1124.27', '달러');

insert into exchange (cur_unit, base_dt, tts, ttb, deal_bas_r, cur_nm)
values ('USD','20221122', '1124.27', '1129.27', '1124.27', '달러');

insert into exchange (cur_unit, base_dt, tts, ttb, deal_bas_r, cur_nm)
values ('USD','20221121', '1124.27', '1129.27', '1124.27', '달러');