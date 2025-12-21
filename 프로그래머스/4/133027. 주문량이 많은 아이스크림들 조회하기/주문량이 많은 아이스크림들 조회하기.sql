select fh.flavor from first_half fh 
left outer join (
select flavor, sum(total_order) as july_total
    from july
    group by flavor
)j on fh.flavor = j.flavor
order by (fh.total_order+j.july_total) desc LIMIT 3;;