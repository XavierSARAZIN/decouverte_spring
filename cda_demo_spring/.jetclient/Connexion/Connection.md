```toml
name = 'Connection'
method = 'POST'
url = 'http://localhost:8080/connexion'
sortWeight = 1000000
id = '779dd023-dde0-44c5-8b6d-6262967750ca'

[auth.bearer]
token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhQGEuY29tIn0.WLK31zXu66JK56jOUK91gZg4HZv3InjphZVqCf80XlU'

[body]
type = 'JSON'
raw = '''
{
  "email" : "a@a.com",
  "password" : "root"
}'''
```
