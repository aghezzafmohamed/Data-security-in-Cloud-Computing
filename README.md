# Data-security-in-Cloud-Computing
## Introduction
<p>Ce projet consiste à concevoir une nouvelle approche qui combine entre le Cloud
Computing et la cryptographie. En effet, le Cloud Computing ou l’informatique en nuage est un
nouveau paradigme de déploiement de systèmes informatique, il offre beaucoup d’avantages en
termes de puissance de calcul, de temps de réponse et de réduction des coûts. Les utilisateurs
peuvent bénéficier pleinement des services Cloud qui permettent de satisfaire leurs besoins à la
demande. Toutefois, comme chaque avancée technologique, externaliser ses ressources
informatiques apporte aussi sa part de risques, notamment en termes de sécurité des données, car
si l’utilisateur ne peut pas avoir ses propres données de manière sécurisée, à tout moment et à partir
de n’importe quel emplacement géographique, alors l’efficacité, les avantages et même la
définition du Cloud Computing seront mis en péril. On observera alors une baisse d’adoption du
Cloud voir même une perte des clients.</p>

## Architecture de base
![architecture de base](https://user-images.githubusercontent.com/46581188/52914053-b9439d00-32bb-11e9-91d5-327a92b3473a.PNG)

## Application
<P>Nous avons essayé de développer une application basée sur l’architecture hybride (Architecture ci-dessus) 
afin de chiffrer les données qui transitent le Cloud.
Ce modèle hybride qui permet de sécuriser les données et de les protéger contre les attaques. Il utilise,
d’une part, l'algorithme de chiffrement symétrique AES afin de bénéficier de ses avantages en termes de 
robustesse et de la rapidité de traitement, et d’autre part, l’algorithme de chiffrement asymétrique RSA 
pour échanger les clés.</p>

###	Authentification
C’est une phase primordiale dans la mise on place d’une l’application. Elle est constituée de deux zones
de saisie simple une réservée au nom d’utilisateur, l’autre pour le mot de passe sur laquelle les caractères
saisis sont cachés et un bouton qui permet d’accéder à l’interface principale si le mot de passe et le login
sont correctes, sinon un message d’erreur va être affiché sur une boite de dialogue.

![authentification](https://user-images.githubusercontent.com/46581188/52914232-d4171100-32bd-11e9-8516-11e35e5ce6b3.png)

### Fenêtre Accueil
![interface principale](https://user-images.githubusercontent.com/46581188/52914310-cada7400-32be-11e9-8f65-7c2c96009dbd.png)

### Fenêtre de Cloud 
Dans cette fenêtre le client peut importer un fichier (Word, Texte) depuis son propre ordinateur dans le cas où le client joue 
le roule d’émetteur, ou bien depuis le cloud dans le cas où le client joue le roule de destinataire. Dans les deux cas le client
doit importer la clé ou bien la saisir dans la zone de clé, pour crypter dans le cas d’émetteur. Après le processus de cryptage, 
le fichier doit être exporter vers le cloud.
![cloudpng](https://user-images.githubusercontent.com/46581188/52914412-ba76c900-32bf-11e9-9cdd-8206d20a30a5.png)

### Fenêtre Sécurité
Cette fenêtre est réservée à l’établissement de connexion entre les utilisateurs de l’application, dans ce cas le serveur se mette
en écoute d’une demande de connexion. Après que les clients sont bien connectés, l’émetteur chiffre la clé et l’envoyer au serveur.
![securite](https://user-images.githubusercontent.com/46581188/52914449-3cff8880-32c0-11e9-9d21-68fcb6545fe1.png)

### Contact
Linkedin: <a href="https://www.linkedin.com/in/mohamed-aghezzaf/">aghezzafmohamed<a/> <br>
Gmail: aghe.mohamed@gmail.com


