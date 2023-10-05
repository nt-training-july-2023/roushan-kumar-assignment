import React from 'react'

function Button({
    id,
    name,
    className,
    onClick,
    type,
    value,
    hidden,
}) {
    return (
        <>
            <button
                id={id}
                name={name}
                className={className}
                onClick={onClick}
                type={type}
                value={value}
                hidden = {hidden}
            >
                {name}
            </button>
        </>
    )
}

export default Button