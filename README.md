# dat100-prosjekt-startkode-2021
[Oppgave1.md](https://github.com/dat100hib/dat100-prosjekt-testing-2021/blob/main/docs/oppgave1.md)
- ✔️ Oppgave 1.1 - Studere klassene Kort og Kortfarge
- ✔️ Oppgave 1.2 - Implementere samlinger av Kort
- ✔️ Oppgave 1.3 - Sortere og stokke Kort
[Oppgave2.md]()
- ✔️ Oppgave 2.1 - Bord-klassen
- ✔️ Oppgave 2.2 - Spiller-klassen
- ✔️ Oppgave 2.3 - Spill-klassen
- ✔️ Oppgave 2.4 - Spill via brukergrensesnitt
[Oppgave3.md]()
- ✔️ Oppgave 3.1 - Random-strategien
- ✔️ Oppgave 3.2 - Implementasjon av First-fit strategi for syd
[Oppgave4.md]()
- ✔️ Oppgave 4.1 - Beste a N runder
- 🟡 Oppgave 4.2 - Bedre strategi for Syd
- ❌ Oppgave 4.3 - Konkurranse med andre grupper

## Statestikk over strategi
- ### Random vs. First-fit, hvor First-fit er imlementert i [SydSpiller.java](src/no/hvl/dat100/prosjekt/kontroll/SydSpiller.java)
Strategien er å spille det første kortet som er lovlig (også en åtter selv om man har andre kort som også kan spilles). Dersom man ikke har lovlige kort å spille, trekker man om man ikke allerede har trukket maks antall ganger. I så fall sier man forbi.
``` 
Uttav 1'000'000 spill har  
  
Random vunnet 527790 spill
First-fit vunnet 472210 spill
```
  
- ### Random vs. Passive strategy, hvor Passive strategy er implementert i [StrategiSpiller.java](src/no/hvl/dat100/prosjekt/kontroll/StrategiSpiller.java)
Strategien kalles passive for den prioriterer handlinger som endrer spilltilstanden minst. 

Strategien er å spille av fargen som allerede ligger nede først. Hvis ikke brukes kort av samme verdi eller åttere. Dersom man ikke har lovlige kort å spille, trekker man om man ikke allerede har trukket maks antall ganger. I så fall sier man forbi.
```
Uttav 1'000'000 spill har

Random vunnet 504358 spill
Passive vunnet 495642 spill
```

- ### First-fit vs. Passive strategy
```
Uttav 1'000'000 spill har

First-fit vunnet 475718 spill
Passive vunnet 524282 spill
```

- ### Random vs. Random
```
Uttav 1'000'000 spill har

NordSpiller vunnet 499694 spill
SydSpiller vunnet 500306 spill
```
