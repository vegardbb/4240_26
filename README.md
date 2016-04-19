# 4240_26
[Liste av relevante lenker](https://github.com/vegardbb/4240_26/blob/helpdesk/progark-doc)

# TODO
+ Tegne spillebrett - legges inn under /android/assets.Størrelse 1500x1500. Hvite kvadrater av størrelse 20x20 der feltene til brettet skal være.
+ Tegne felt for brett - legges inn under /android/assets. Størrelse 20x20. Fire forskjellige filer.
+ Tegne spillebrikker, rundinger, en farge.
+ Definer flytt fra ett fel til neste for playerActor
+ Ta bort Die - klasse?
+ Definer initgame - metode i GameController
  * Generer spillere
  * Generer felt

# Innhold
+ model - Klasser som holder på spillets data
+ controller - Klasser som instansierer og oppdaterer spilldata, og som sender visningsdata opp til view-pakke. Inneholder
+ view - tegner visningsdata

# Myldring
+ Benytt gdx.freetype til å tegne skalerbar tekst på skjermen
+ Brett tegnes på følgende måte: Lag en png - bildefil med hull der hvert skal sitte.
+ Hvert felt er et passe stort kvadrat, med lengde på eksempel 20 piksler