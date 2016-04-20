(function (){

    var app = angular.module('search-deliveries', ['jumpva']);

    app.controller('SearchDeliveriesController', function ($scope, $uibModalInstance, logedUser  ) {
        $scope.logedUser = logedUser;
        $scope.destruyeMapa = true;


        $scope.unassignedDeliveries = [
                {
                    origen: "Valladolid",
                    destino: "Palencia",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "Santander",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "Galicia",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "LLanes",
                    distancia: 50,
                    puja:0
                },
                {
                    origen: "Valladolid",
                    destino: "Valencia",
                    distancia: 50,
                    puja:0
                },
                {
                    origen: "Valladolid",
                    destino: "Cadiz",
                    distancia: 50,
                    puja:0
                },
                {
                    origen: "Valladolid",
                    destino: "Pamplona",
                    distancia: 50,
                    puja:0
                }
        ];
        $scope.origen = "Valladolid"

        $scope.cancel = function () {
          $uibModalInstance.close('cancel');

        };
        $scope.setOver = function(delivery) {
            $scope.origen = delivery.origen;
            $scope.destino = delivery.destino;
            console.log(delivery);
            $scope.destruyeMapa = true;


        }
    });
})();
