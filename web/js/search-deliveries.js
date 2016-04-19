(function (){

    var app = angular.module('search-deliveries', ['jumpva']);

    app.controller('SearchDeliveriesController', function ($scope, $uibModalInstance, logedUser  ) {
        $scope.logedUser = logedUser;

        $scope.pujas = [
                {
                    transportista: "Paco",
                    valoracion: 3,
                    precio: 50
                },
                {
                    transportista: "Juan",
                    valoracion: 3,
                    precio: 65
                },
                {
                    transportista: "Luis",
                    valoracion: 3,
                    precio: 32
                },
                {
                    transportista: "Miguel",
                    valoracion: 3,
                    precio: 45
                }
        ];


        $scope.cancel = function () {
          $uibModalInstance.dismiss('cancel');
        };
    });
})();
