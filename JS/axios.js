            import axios from axios;

            const apiKey = 'da6153fa7589cdd5ae0121501c4193b4';

            // Ville pour laquelle vous voulez obtenir les informations météorologiques
            const ville = 'Lille';

            // URL de l'API OpenWeatherMap
            const url = `http://api.openweathermap.org/data/2.5/weather?q=${ville}&appid=${apiKey}`;

            // Création d'une requête HTTP avec axios
            axios.get(url)
                .then(response => {
                    const data = response.data;
                    console.log(`La température à ${data.name} est de ${Math.round(data.main.temp - 273.15)}°C.`);
                })
                .catch(error => console.error('Une erreur est survenue : ', error));