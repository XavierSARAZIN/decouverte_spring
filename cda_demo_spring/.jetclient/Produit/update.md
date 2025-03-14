```toml
name = 'update'
method = 'PUT'
url = 'http://localhost:8080/produit/'
sortWeight = 4000000
id = '80c2a775-79b9-4f86-b78f-92143687cca4'

[body]
type = 'JSON'
raw = '''
{
  "id": 3,
  "nom": "Lenovo Legion Go S",
  "code": "llgs",
  "description": "Console portable gaming sous SteamOS",
  "prix": 499.99,
  "etat": {
    "id": 3,
    "nom": "correct"
  },
  "etiquettes": [
    {
      "id": 3
    }
  ]
}'''
```
