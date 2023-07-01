# Qussai Khalil

## Todo List 

### Beskrivning av projektet
-Projektet:
Beskrivning av projektet:
Projektet syftar till att utveckla en Todo List-applikation som hjälper användare att hantera sina uppgifter. Applikationen möjliggör skapande, visning, uppdatering och borttagning av todos, samt hantering av användare.

### Vad du har gjort
Jag har utvecklat en Todo List-applikation med hjälp av Java och använt mig av en SQLite databas för att lagra och hantera todos och användare. Applikationen använder sig av ett lageravdelning mönster (facade pattern) för att abstrahera databas åtkomsten och erbjuda en enkel gränssnitt för att interagera med Todos och användare.




## Planering
Inför projektet gjorde jag följande planering:

-Analys av krav: Jag identifierade och analyserade de funktionella och icke-funktionella kraven för applikationen, inklusive skapande, visning, uppdatering och borttagning av todos och användare.

-Design och arkitektur: Jag skapade en designskiss och planerade applikationsstrukturen. Jag valde att använda ett lagerdelningsmönster för att separera databasåtkomstlogik från affärslogik.

-Databasdesign: Jag utformade en databasstruktur för att lagra todos och användare. Jag skapade även SQL-skript för att skapa de nödvändiga tabellerna och relationerna.

-Implementering: Jag implementerade de olika funktionerna i applikationen, inklusive skapande, visning, uppdatering och borttagning av todos och användare. Jag använde JDBC (Java Database Connectivity) för att ansluta till databasen och utföra CRUD-operationer.


### Lösningsförslag innan uppgiften påbörjas

Innan jag började implementera uppgiften skapade jag pseudokod och ett aktivitetsdiagram för att planera och visualisera flödet i applikationen. Jag använde också lucid för att hantera mina uppgifter och följa en agil projektmetodik.

Arbetet och dess genomförande:
Jag började med att skapa en TodoFacadeDB-klass för att abstrahera databas åtkomsten för todos och en UserfacadeDB-klass för att hantera användare. Jag skapade även en Databas-klass för att hantera anslutningen till databasen.

Efter att ha etablerat anslutningen till databasen och skapat tabellerna för todos och användare, implementerade jag de olika funktionerna i applikationen baserat på användare interaktionen. Jag använde en scanner för att läsa inmatning från användaren och anropade de relevanta metoder i facade-klasserna för att utföra åtgärderna i databasen.

Under arbetets gång stötte jag på vissa utmaningar. En av de svåraste delarna var att hantera inmatningen och validera användarens indata för att undvika felaktiga eller ogiltiga värden. Jag använde olika metoder som nextLine(), nextInt(), och nextBoolean() för att läsa in olika typer av data från användaren och inkluderade validering och felhantering för att hantera felaktiga inmatningar.

En annan utmaning var att implementera uppdatering av todos och användare. Jag behövde först hämta befintliga värden från databasen och sedan låta användaren ange nya värden för att uppdatera de relevanta fälten. Jag behövde också hantera fallet när användaren lämnade ett fält tomt och behöll det befintliga värdet.

Jag gjorde några ändringar i min ursprungliga lösning under arbetets gång. Till exempel upptäckte jag att jag behövde lägga till en metod för att skriva ut detaljer för todos och användare för att förbättra användarupplevelsen och lättare kunna inspektera data.

### Vad som varit svårt

Jag stötte på stora utmaningar när det kom till att skapa tester för databasen. Min enda lösning var att förlita mig helt på Chat GPT och försöka förstå resonemanget bakom den kod den genererade. Projektet i sin helhet var otroligt krävande. Det var en konstant kamp att få programmet att agera på det sätt som var avsett.

### Beskriv lite olika lösningar du gjort

### Beskriv något som var besvärligt att få till

### Beskriv om du fått byta lösning och varför i sådana fall

## Reflektion & Slutsatser

### Vad gick bra

### Vad gick dåligt

### Vad har du lärt dig

### Vad hade ni gjort annorlunda om ni gjort om projektet

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
