############README_Théo_CHAILLAN_Jules_VERMES##################################

#####################Pré-requis################################################

- Premièrement, il est important de venir télécharger le dossier complet. Pour cela il faut venir cliquer sur le bouton code en vers sur Github puis "download ZIP".
- Une fois que cela est fait, vous dézipez le fichier et récupérait le dossier RIOC, pour pouvoir l'importer en tant que nouveau projet sur éclipse.
- Version de Eclipse : 2022-09 (4.25.0)
- Version de MySQL Worbench : 8.0.31
- Version de MySQL : 8.0.31
- Installer sur le eclipse MarketPlace (pour accéder au marketplace, veuillez aller dans help et eclipse marketplace):
	- Spring tools 4
	- MapStruct Eclipse
	- Eclipse Web developper tools 3.27
	- Eclipse Entreprise Java and Web Developper tools 3.27
- Pour MySQL Workbench, il vous faut créer une instance avec en données :
	- localhost:3306
	- user : root
	- password : admin

#####################Etape Workbench###########################################

- Pour lancer le code, il faut tout d'abord exécuter MySQL Workbench et Shell.
- Ensuite, sur Workbench, après que vous ayez créé l'instance avec les informations fournis plus haut, ouvrer l'instance en cliquant dessus et en rentrant le mot de passe.
- Une fois dans l'instance, créer une base de données avec pour nom "test".
- Une fois que la base de données est créée, tout est bon du côté de workbench.

#####################Clean Install et Skip test################################

- Afin de pouvoir lancer le code, il est très important qu'après avoir effectué les actions précédentes, et importer le dossier rioc sur éclipse,
- Il faut faire un clic droit sur le dossier situé dans la barre gauche d'éclipse afin de venir cliquer sur "run as"
- Puis cliquer sur "Maven build ...".
- Ensuite une fenêtre va s'ouvrir,
- Dans celle-ci, il faut :
	- Tapper "clean install" dans la section goals
	- Et venir cocher la case "Skip tests".
- Une fois que tout cela est fait, il devrait désormais être possible de lancer le code en faisant "run as" puis "spring boot app"

#####################Etape pour accéder au swagger#############################

- Pour accéder au swagger, il vous faut désormais lancer le code.
- Une fois que celui-ci est démarré, rendez-vous à l'url : http://localhost:8080/swagger-ui/index.html
- Voilà, vous pouvez désormais utiliser les différentes fonctions que nous avons pu mettre en place.

#####################Point d'arrêt#############################################

- Pour ce qui est de notre avancement :
	- Nous avons réalisé les différentes requête HTTP :
		- Get All
		- Get by id
		- Delete by id
	- Nous avons terminé la partie sur le one-to-one
	- Nous avons fait notre liaison one-to-many
	- Nous avons mis en place le fait de ne pas pouvoir ajouter un iban si l'account n'existe pas
