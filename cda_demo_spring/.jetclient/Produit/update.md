```toml
name = 'update'
method = 'PUT'
url = 'http://localhost:8080/produit/2'
sortWeight = 4000000
id = '80c2a775-79b9-4f86-b78f-92143687cca4'

[body]
type = 'JSON'
raw = '''
{
  "id" : 2,
  "description" : "descr",
  "nom" : "modif",
  "code" : "mdf",
  "prix" : 2.5
}'''
```
