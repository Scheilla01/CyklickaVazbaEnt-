# CyklickaVazbaEnt-
Cycklicka vazna entit OneToMany ManyToOne

https://www.youtube.com/watch?v=THv-TI1ZNMk
https://www.youtube.com/watch?v=ZY4mUro6Kd0


Rekněme, že máme entitu User (uživatel) a Location (poloha). Entita User má list entit Location, aby byla dodržena vazba uživatele na jeho polohu v databázi. Abychom vazbu správně implementovali do tříd, musí mít i jednotlivé polohy pak odkaz na svého User, kterému patří, tedy i z druhé strany. Zatím žádný problém.

Pokud bychom ovšem chtěli uživatele třeba vypsat, Spring by nám celý list vypsal jako JSON. A snažil by se zde vypsat onen odkaz poloha na User. U uživatele by ale vypsal zas jako jeho vlastnosti s tím stejným listem Articlů, každý článek by zas vypsal User se seznamem articlů a asi už dokážete říci, co by se stalo. Vznikl by nekonečně velký reponse, nekonečně se opakujících dat uživatelů a jejich článků a jejich uživatelů a jejich článků a jejich uživatelů...

Oboustranných odkazů se zbavit nechceme, protože by jinak mohlo být komplikované na různých částech aplikace získávat data. Proto si kromě entit User a Article, které na sebe mají oboustranné odkazy, vytvoříme i UserDTO a ArticleDTO, které budou určené jako zjednodušené objekty pro Spring a oboustranný odkaz mezi sebou mít nebudou. Sice v UserDTO uložíme list ArticleDTO, ale v ArticleDTO ukládáme pouze Long userId, jakožto Id našeho User, ne kompletní referenci na jeho instanci.
