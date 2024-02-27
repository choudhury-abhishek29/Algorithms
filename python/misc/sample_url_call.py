import requests

url = "https://app.amberflo.io/account-setting/logo"

headers = {"accept": "image/*"}

response = requests.get(url, headers=headers)

print(response.text)