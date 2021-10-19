## Statestikk over strategi
### Random vs. First-fit, hvor First-fit er imlementert i [SydSpiller.java](src/no/hvl/dat100/prosjekt/kontroll/SydSpiller.java)
Strategien er å spille det første kortet som er lovlig (også en åtter selv om man har andre kort som også kan spilles). Dersom man ikke har lovlige kort å spille, trekker man om man ikke allerede har trukket maks antall ganger. I så fall sier man forbi.
``` 
Uttav 1'000'000 spill har  
  
Random vunnet 527790 spill
First-fit vunnet 472210 spill
```
  
### Random vs. Passive strategy, hvor Passive strategy er implementert i [StrategiSpiller.java](src/no/hvl/dat100/prosjekt/kontroll/StrategiSpiller.java)
Strategien kalles passive for den prioriterer handlinger som endrer spilltilstanden minst. 

Strategien er å spille av fargen som allerede ligger nede først. Hvis ikke brukes kort av samme verdi eller åttere. Dersom man ikke har lovlige kort å spille, trekker man om man ikke allerede har trukket maks antall ganger. I så fall sier man forbi.
```
Uttav 1'000'000 spill har

Random vunnet 504358 spill
Passive vunnet 495642 spill
```

### First-fit vs. Passive strategy
```
Uttav 1'000'000 spill har

First-fit vunnet 475718 spill
Passive vunnet 524282 spill
```

### Random vs. Random
```
Uttav 1'000'000 spill har

NordSpiller vunnet 499694 spill
SydSpiller vunnet 500306 spill
```
