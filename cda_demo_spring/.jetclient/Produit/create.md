```toml
name = 'create'
method = 'POST'
url = 'http://localhost:8080/produit'
sortWeight = 2000000
id = 'c090859f-69b2-4df3-b1fb-2ca9e9724ada'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhQGEuY29tIn0.WLK31zXu66JK56jOUK91gZg4HZv3InjphZVqCf80XlU'

[body]
type = 'JSON'
raw = '''
{
  "nom" : "eeee",
  "description" : "Une boutille de 1L de fanta",
  "prix" : 1,
  "code" : "rrr",
  "etat" : {
    "id" : 1
  },
  "etiquettes" : [
    {
      "id" : 1
    }
  ]
}'''
```
