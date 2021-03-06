# SOP_Location_Service

CRUD Location Service and filter from user current location

## Compiles and hot-reloads for development


```bash
docker-compose build
docker-compose up
```
or
```bash
cd app
python manage.py runserver
```

## Usage

- get all location
```
    GET http://35.225.198.249:8000/location/
```

```python
   # Response Type
    [
      {
          "id": int,
          "name": string,
          "description": string,
          "created_at": string,
          "latitude": float,
          "longitude": float
      }
    ]
```
- add location
```
    POST http://35.225.198.249:8000/location/
```
```python
    # Payload Type
    [
      {
        "name": string,
        "description": string,
        "latitude": float,
        "longitude": float
      }
    ]
```

- get specific location
```
    GET http://35.225.198.249:8000/location/<id>
```

```python
   # Response Type
    {
      "id": int,
      "name": string,
      "description": string,
      "created_at": string,
      "latitude": float,
      "longitude": float
    }
```

- edit location infomation
```
    PATCH http://35.225.198.249:8000/location/<id>
```
```
    PUT http://35.225.198.249:8000/location/<id>
```

```python
    # Payload Type
    # PUT requires all fields, patch otherwise
    [
      {
          "name": string,
          "description": string,
          "latitude": float,
          "longitude": float
      }
    ]
```

- delete location infomation
```
    DELETE http://35.225.198.249:8000/location/<id>
```

- get filter location using user location
```
    GET http://35.225.198.249:8000/location/filter
```
```python
    # Parameter
    lat = "float: user's latitude"
    lon = "float: user's longitude"
    km = "float: filter distance"
```
```python
    # Response Type
    [
      {
          "id": int,
          "name": string,
          "description": string,
          "created_at": string,
          "latitude": float,
          "longitude": float
      }
    ]
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)