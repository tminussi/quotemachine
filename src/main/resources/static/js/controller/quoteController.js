angular.module('quoteMachine')
    .controller('quoteController', ['$scope', 'QuoteService', function($scope, quoteService) {

        $scope.getNewQuote = function() {
            init();
        };

        var init = function(){
            quoteService.quotes.findOne(function(data){
                $scope.quote = data;
            });
        };
        init();
    }]);