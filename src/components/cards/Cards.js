import React from 'react';
import './Cards.css';

function Cards({title, imageUrl, body}) {
    return (
        <div className="card-container">
            <div className="image-container">
                <img src={imageUrl} alt=""/>
            </div>
            <div className="card-title">
                <h1>{title}</h1>
            </div>
            <div className="card-body">
                {body}
            </div>

        </div>

    );
}

export default Cards;
