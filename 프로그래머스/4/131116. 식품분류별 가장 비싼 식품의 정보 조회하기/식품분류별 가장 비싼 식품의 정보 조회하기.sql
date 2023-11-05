-- 코드를 입력하세요
select category, price as max_price, product_name
from (
    select *
    from food_product
    where category in ('과자', '국', '김치', '식용유')
    order by price desc
    limit 2000000000
) d
group by category
order by price desc

# select *
# from food_product
# where category in ('과자', '국', '김치', '식용유')
# order by price desc
# limit 2000000000