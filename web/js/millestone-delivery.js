(function (){

    var app = angular.module('millestone-delivery', []);

    app.controller("MillestoneController", function (user, $scope) {
        var self = this;

        self.getMilestoneType = function(milestone){
            switch(milestone.authorEmail){
                case '':
                    return 'info';
                case user.email:
                    return 'success';
                default:
                    return 'warning';
            };
        }

        self.addMilestone = function(shipment){
            console.log(self.newMilestone.body);

            self.newMilestone.date = Date.now();

            if($scope.reviewForm.$valid){
                user.postNewHitoToShipment(shipment.id, self.newMilestone)
                        .then(handleRequest(),handleBadRequest());
            }
        };

        function handleRequest(res) {
            $scope.delivery.milestoneList.push(self.newMilestone);
            self.newMilestone = {};
            $scope.reviewForm.$setPristine();
            $scope.reviewForm.$setUntouched();

        };

        function handleBadRequest(res) {

        };

    });
})();
