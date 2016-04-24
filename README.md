# 4240_26
[Liste av relevante lenker](https://github.com/vegardbb/4240_26/blob/helpdesk/progark-doc)

# TODO
+ Ta bort Die - klasse?
+ Definer bruk av sjansefelt
  * Implementer statusmelding for å varsle spiller om hva som skjer
  * Implementer Tilbake til start
  * Implementer Bytt plass med tilfeldig spiller.
  * Implementer Bakoverkast neste runde.
  * Implementer Unngå stige eller sjansefelt neste runde.
  * Implementer Dobbel-flytt neste runde
+ Kommentarer i kildekode, og se linje 194 - GameScreenController
+ Forandre game breaker til muligens avgjørende, men fortsatt usikkert sjansefelt

# Pakker
+ model - Klasser som holder på spillets data
+ controller - Klasser som instansierer og oppdaterer spilldata, og som sender visningsdata opp til view-pakke.
+ view - tegner visningsdata

# Forslag
+ Benytt gdx.freetype til å tegne skalerbar tekst på skjermen
+ Hvert felt er et passe stort kvadrat, tegnet fra et png - bilde

# COTS
+ OpenSans-Regular.ttf Kilder ukjent
+ Et bilde av et brett Kilder ukjent
+ ui-orange.atlas - hentet fra http://www.microbasic.net/2014/05/free-cc0-ui-elements-to-be-used-in-your-libgdx-games/ Lisens: Public Domain, CC0. Laget av Kenny.NL