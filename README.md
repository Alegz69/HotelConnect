Cap. 1. Descrierea generală a proiectului

Aplicația HotelConnect a fost concepută pentru a facilita organizarea hotelului in ceea ce privește personalul și rezervarea camerelor de hotel într-un mod cât mai eficient. “Adminul”, cel care se ocupă de gestionarea angajaților, are o interfață special dezvoltată pentru el, care îi permite să elimine sau să adauge angajați și să stabilească pentru fiecare dintre ei “tura”, determinând data și orele de lucru pentru fiecare angajat. Utilizatorii au posibilitatea de a rezerva un anumit număr de camere disponibile, de a accesa o galerie foto cu poze ale hotelului și o rubrică  în care dispun de informații de contact ale acestuia . Aplicația oferă o interfață destul de prietenoasă și ușor de folosit care dispune de o structură logică și ușor de înțeles.


Cap. 2. Structura proiectului 

2.1.  Pachete și fișiere Java

Proiectul este împărțit în mai multe pachete, fiecare gestionând o anumită parte a funcționalității. Mai jos sunt enumerate pachetele principale și fișierele asociate. Fișierul MainActivity.java reprezintă activitatea principală a aplicației, acesta conține logica de gestionare a sistemului de autentificare, inclusiv interacțiunea utilizatorului cu interfața în ceea ce privește introducerea datelor de logare.
        Fișierul ViewsActivity.java descrie activitatea centrală a aplicației care conține un sistem de navigare tip sertar. Acesta apare la glisarea în partea dreaptă a ecranului de către utilizator și conține rubrici precum galerie foto, contact, logout.
       Admin_Activity.java este activitatea dedicată administrării hotelului de către admin și prezintă funcționalități precum lista angajaților și turele acestora , iar Admin_Activity2.java are funcționalități legate de adăugarea și eliminarea angajaților din personalul efectiv al hotelului, precum și setarea datei și orelor de muncă ale acestora. Aceste fișiere fac parte din pachetul com.exemple.projectsda 
       Următorul pachet, numit com.exemple.projectsda.fragments, se referă la componentele care apar în urma accesării sistemului de navigare de tip sertar. HomeFragment.java este fragmentul destinat rezervărilor de către client. Aici utilizatorul poate oferi detalii legate de numărul de camere rezervate și persoane staff-ului hotelului. GalleryFragment.java oferă posibilitatea vizualizării galeriei foto a hotelului. Afișează o colecție de imagini, ilustrând o notă nuanțată a felului in care arată hotelul, a amplasamentului acestuia și a posibilelor facilități de care acesta dispune. ContactFragment.java furnizează informațiile de contact ale hotelului. Aici sunt afișate date precum adresa de e-mail, numărul de telefon și adresa fizică a hotelului
        În fișierele admin_activity.xml și admin_activity2.xml este implementat aspectul activității de adăugare și eliminare angajați, cât și aspectul funcționalității gestionării.  

2.2.  Fișiere XML


Fișierele XML au funcționalități legate de aspectul aplicației, contribuind la estetica programului și făcându-l cât mai ușor de utilizat. activity_main.xml definește aspectul activității principale și 
include interfața de autentificare. Conține câmpuri pentru datele de logare, butoane de conectare, și o căsuță „Remember me”. În fișierul activity_home.xml este definit aspectul fragmentului pentru rezervări, conținând elemente pentru a introduce și a vizualiza detaliile rezervărilor camerelor.
         Aspectul fragmentului de vizualizare a galeriei foto este ilustrat in fișierul activity_gallery.xml, iar în activity_contact.xml se realizează aspectul fragmentului pentru informații de contact, conținând elemente de interfață și text pentru afișarea detaliilor de contact cum ar fi numărul de telefon, adresa de e-mail și adresa fizică a hotelului. Fișierul nav_header_views.xml definește antetul meniului de navigare și conține informații despre utilizator, cum ar fi imaginea de profil și numele. Aspectul activității principale cu sistem de navigare tip sertar este ilustrat în views_activity.xml, iar în drawer_menu.xml se definește meniul de navigare lateral și conține opțiuni pentru navigarea în aplicație.

2.3.  Resurse 

Proiectul utilizează diverse resurse pentru a îmbunătăți aspectul și funcționalitatea aplicației. Acestea sunt definite în directorul res al proiectului. @drawable/iconuser reprezintă imaginea utilizată pentru avatarul utilizatorului. Este afișată în diferite locuri ale aplicației, oferind o identitate vizuală utilizatorului. În @drawable/bg este conținută imaginea de fundal folosită pentru ecranele principale ale aplicației. Fundalul contribuie la atmosfera generală a aplicației și este esențial pentru crearea unei experiențe vizuale plăcute. Resursa @drawable/blur_layer reprezintă un fundal cu un efect de încețoșare(blur). Este utilizată pentru a crea un strat de încețoșare pe întreaga aplicație, adăugând un aspect estetic și concentrând atenția asupra conținutului principal.
        Alte resurse, cum ar fi culori, dimensiuni și stiluri, sunt definite în directorul res/values. Acestea joacă un rol crucial în definirea aspectului și comportamentului componentelor interfeței utilizatorului, facilitând menținerea unui aspect coerent și a unei experiențe de utilizare uniforme în întreaga aplicație.


Cap. 3. Funcționalități principale

3.1.  Autentificare

Activitatea MainActivity.java gestionează procesul de autentificare. Utilizatorii introduc datele de conectare (nume de utilizator și parolă), iar aplicația validează aceste informații pentru a permite sau nu accesul la funcționalitățile ulterioare. Se integrează opțiunea de "remember me" pentru a reține datele utilizatorului și a facilita logarea ulterioară.
      
3.2.  Rezervări


Fragmentul HomeFragment.java permite utilizatorilor să efectueze rezervări de camere de hotel. Utilizatorii pot specifica detaliile rezervării, cum ar fi numărul de camere și numărul de 
persoane. Informațiile introduse sunt apoi gestionate și procesate pentru a confirma sau anula rezervarea.

3.3.  Administrare

Administrarea este realizată prin două fișiere: Admin_activity.java in care se poate găsi o listă cu toți angajații, poziția pe care aceștia o ocupă la hotel precum și turele lor de lucru iar Admin_activity2.java permite administratorului să adauge noi angajați în sistem, furnizând informații precum numele angajatului, poziția și orele de lucru. De asemenea, există opțiuni pentru a reveni înapoi în meniul principal sau să finalizeze procesul de adăugare a angajatului.
        Aceste funcționalități sunt esențiale pentru asigurarea unei experiențe eficiente de administrare și gestionare a hotelului, oferind un control extins asupra datelor și angajaților implicați în activitatea zilnică.
        Această structură modulară și funcționalitățile distincte permit utilizatorilor să beneficieze de o experiență personalizată în funcție de rolul lor în cadrul aplicației HotelConnect. Utilizatorii obișnuiți se pot bucura de funcționalitățile de rezervare și explorare a hotelului, în timp ce administratorii au acces la un set avansat de comenzi și opțiuni pentru gestionarea eficientă a activității hoteliere.

3.4.  Informații

Utilizatorii pot vizualiza o galerie foto a hotelului implementată în GalleryFragment.java. Imaginile furnizate oferă utilizatorilor o perspectivă vizuală asupra aspectului hotelului, inclusiv a facilităților și atmosferei generale. Informațiile de contact pentru hotel se găsesc în ContactFragment.java. Utilizatorii pot accesa această secțiune pentru a găsi detalii importante și utile pentru a intra în contact cu hotelul.


Cap. 4. Interfața utilizatorului

4.1.  Aspectul general

Aspectul general al aplicației "HotelConnect" este conceput cu atenție pentru a oferi o experiență vizuală plăcută și coerentă. Culorile și stilurile sunt selectate cu atenție și definite în mod coerent în întregul proiect. Aceasta asigură o identitate vizuală solidă și facilitează recunoașterea și asocierea elementelor din diferite ecrane. Design-ul interfeței de utilizator este conceput pentru a fi prietenos și intuitiv. Elementele interfeței sunt plasate strategic pentru a facilita navigarea și pentru a asigura o utilizare fără efort pentru utilizatori. 

4.2.  Meniu de navigare lateral

Sistemul de navigare tip sertar (DrawerLayout) este un aspect esențial al interfeței de utilizator și oferă o modalitate intuitivă de a accesa diferite funcționalități ale aplicației. Acest sistem este implementat în views_activity.xml și contribuie la experiența generală de utilizare. Meniul de navigare lateral oferă acces rapid la funcționalități cheie ale aplicației, cum ar fi vizualizarea galeriei foto, contactarea hotelului sau deconectarea din cont.


Cap. 5. Concluzii

5.1.  Concluzii generale

"HotelConnect" este o aplicație Android care aduce o soluție eficientă și modernă pentru gestionarea rezervărilor de camere de hotel. Prin funcționalitățile sale, precum autentificarea securizată, posibilitatea de a realiza rezervări, vizualizarea galeriei foto și contactarea hotelului, aplicația oferă o experiență completă și intuitivă utilizatorilor. 
         Interfața de utilizator bine concepută, împreună cu funcționalitățile clare și bine implementate, contribuie la eficiența și ușurința de utilizare a aplicației. Asigurarea unei coerențe în design și adaptabilitatea la diferite dimensiuni de ecrane adaugă un plus în ceea ce privește experiența utilizatorului. Implementarea modulelor de administrare aduce un beneficiu suplimentar, permițând adminului să gestioneze personalul și să aibă control asupra rezervărilor și a altor aspecte ale activității hotelului.

5.2.  Direcții viitoare de dezvoltare

Pentru a continua îmbunătățirea și extinderea funcționalităților aplicației, câteva direcții viitoare de dezvoltare pot fi luate în considerare: implementarea unui sistem de evaluare și feedback pentru rezervări și serviciile hotelului, dezvoltarea unui sistem de notificări pentru a ține utilizatorii la curent cu rezervările și evenimentele importante, integrarea cu servicii externe pentru posibilitatea de a face plăți online și a verifica disponibilitatea camerelor în timp real, extinderea funcționalității de administrare, inclusiv rapoarte detaliate și analize statistice.

5.3.  Impresii

"HotelConnect" oferă o experiență plăcută și eficientă pentru utilizatorii care doresc să realizeze rezervări de hotel într-un mod modern și accesibil. Design-ul atrăgător, funcționalitățile bine gândite și ușurința în utilizare fac din această aplicație o alegere potrivită pentru cei care apreciază comoditatea în gestionarea rezervărilor de călătorii.
         Efortul de a integra și module de administrare relevante pentru personalului hotelului adaugă valoare și flexibilitate, făcând aplicația potrivită atât pentru utilizatorii obișnuiți, cât și pentru administrație.
         În concluzie, "HotelConnect" se află la intersecția dintre utilitate și design plăcut, contribuind la simplificarea și eficientizarea procesului de rezervare a camerelor de hotel.

