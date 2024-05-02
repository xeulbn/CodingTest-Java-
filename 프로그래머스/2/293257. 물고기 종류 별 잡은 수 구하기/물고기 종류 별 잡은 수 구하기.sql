select count(*) as FISH_COUNT, FI.FISH_NAME
from FISH_NAME_INFO FI
join FISH_INFO F on FI.FISH_TYPE=F.FISH_TYPE
group by FI.FISH_TYPE,FI.FISH_NAME
order by FISH_COUNT desc;