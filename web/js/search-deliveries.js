(function (){

    var app = angular.module('search-deliveries', ['jumpva']);

    app.controller('SearchDeliveriesController', function ($scope, $uibModalInstance, logedUser  ) {
        $scope.logedUser = logedUser;


        $scope.unassignedDeliveries = [
                {
                    origen: "Valladolid",
                    destino: "Palencia",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "Palencia",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "Palencia",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "Palencia",
                    distancia: 50,
                    puja:0
                }
        ];


        $scope.cancel = function () {
          $uibModalInstance.dismiss('cancel');
        };
    });
})();
