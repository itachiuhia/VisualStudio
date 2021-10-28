class comapany1:
    cars_manuf = 100
    def x(self):
        comapany1.cars_manuf = 150


class comapany2:
    cars_manuf = 1000
    def x(self):
        print(comapany2.cars_manuf*comapany1.cars_manuf)

class comapany3(comapany1):
    def x(self):

        cars_manuf = 10



class Partner(comapany2, comapany1):
    def x(self):
        partner_car_val = comapany2.cars_manuf/comapany3.cars_manuf

        return partner_car_val

obj = Partner()

print(obj.x())